# Copyright 1999-2006 Gentoo Foundation
# Distributed under the terms of the GNU General Public License v2
# $Header: $

EAPI="2"
JAVA_PKG_IUSE="doc source"
WANT_ANT_TASKS="ant-nodeps ant-junit4 ant-junit"

S="${WORKDIR}/${PN}"

EANT_BUILD_XML="${S}/build.xml"

inherit eutils fdo-mime java-pkg-2 java-ant-2

DESCRIPTION="Creates virtual webcam to broadcast over the internet."
HOMEPAGE="https://code.google.com/p/webcamstudio/"

SRC_URI="http://webcamstudio.googlecode.com/files/${PN}_${PV}.tar.bz2"

LICENSE="GPL-2"
SLOT="0"
KEYWORDS="~x86 ~amd64"
IUSE=""

DEPEND=">=virtual/jdk-1.6
	dev-libs/glib:2
	virtual/ffmpeg
	media-libs/gstreamer:0.10
	media-libs/gst-plugins-bad
	media-libs/gst-plugins-base
	media-libs/gst-plugins-good
	media-libs/gst-plugins-ugly
	media-sound/pulseaudio
	dev-java/absolutelayout
	dev-java/appframework
	dev-java/commons-cli:1
	dev-java/commons-codec
	dev-java/commons-httpclient:3
	dev-java/commons-io
	dev-java/commons-lang:2.1
	dev-java/jna
	dev-java/jsr305
	dev-java/log4j
	java-virtuals/javamail
	dev-java/slf4j-api
	dev-java/slf4j-nop
	dev-java/swing-worker
	|| ( media-video/webcamstudio-module media-video/v4l2loopback )"
RDEPEND="${DEPEND}"

java_prepare() {
	# Fix avconv to gstreamer since avconv fails on some webcams
	einfo "Fixing webcam source command line..."
	sed -i \
		-e "s?#video=gst-launch-0.10?video=gst-launch-0.10?" \
		-e "s?#audio=gst-launch-0.10?audio=gst-launch-0.10?" \
		-e "s?video=avconv?#video=avconv?" \
		-e "s?audio=avconv?#audio=avconv?" \
		src/webcamstudio/externals/linux/sources/webcam.properties \
		|| die "Failed to fix webcam source command line"

	# Fix avconv/gstreamer/ffmpeg binaries absolute paths
	einfo "Fixing some binaries' paths..."
	sed -i \
		-e "s?=gst-launch-0.10?=/usr/bin/gst-launch-0.10?" \
		-e "s?=avconv?=/usr/bin/ffmpeg?" \
		-e "s?=ffmpeg?=/usr/bin/ffmpeg?" \
		src/webcamstudio/externals/linux/*.properties \
		src/webcamstudio/externals/linux/*/*.properties \
		|| die "Failed to fix binaries' paths"

	# CD to the proper folder here, so if upstream changes the tree structure
	# to be easier to fix it.
	cd "libraries"

	# Remove some bundled java libs and use Gentoo native ones
	einfo "Removing the unnecessary project's jar library files..."
	rm -v 	AbsoluteLayout*.jar \
			AppFramework*.jar \
			commons-*.jar \
			jcl-over-slf4j-*.jar \
			jffmpeg-*.jar \
			jna*.jar \
			jsr*.jar \
			log4j-*.jar \
			mail*.jar \
			slf4j-*.jar \
			swing-*.jar \
		|| die "Failed to remove some of the project's jar library files"

	java-pkg_jar-from absolutelayout absolutelayout.jar AbsoluteLayout-7.0.jar
	java-pkg_jar-from appframework appframework.jar AppFramework-1.03.jar
	java-pkg_jar-from commons-cli-1 commons-cli.jar commons-cli-1.2.jar
	java-pkg_jar-from commons-codec commons-codec.jar commons-codec-1.6.jar
	java-pkg_jar-from commons-httpclient-3 commons-httpclient.jar commons-httpclient-3.1.jar
	java-pkg_jar-from jna jna.jar jna-3.2.7.jar
	java-pkg_jar-from jna platform.jar jna-platform-3.2.7.jar
	java-pkg_jar-from commons-io-1,commons-lang-2.1,jsr305,log4j,sun-javamail,slf4j-api,slf4j-nop,swing-worker
}

pkg_setup() {
	java-pkg-2_pkg_setup
}

src_compile() {
	java-pkg-2_src_compile
}

src_install() {
	java-pkg_dojar dist/WebcamStudio.jar

	# Install only non-portage .jar bundled files
	java-pkg_jarinto /opt/${PN}/lib
	java-pkg_dojar libraries/jtwitter*.jar
	java-pkg_dojar libraries/netty*.jar
	java-pkg_dojar libraries/zxing*.jar

	# Prepare a launcher for the main application
	java-pkg_dolauncher ${PN} \
		--java_args "-splash:/opt/${PN}/start.gif" \
		--main webcamstudio.WebcamStudio \
		--jar WebcamStudio.jar

	newicon "debian/webcamstudio.png" webcamstudio.png
	domenu "debian/${PN}.desktop"

	use doc && java-pkg_dojavadoc dist/javadoc
	use source && java-pkg_dosrc src/*

	insinto /opt/${PN}
	doins src/webcamstudio/resources/start.gif
}

pkg_postinst() {
	fdo-mime_desktop_database_update
}

pkg_postrm() {
	fdo-mime_desktop_database_update
}
