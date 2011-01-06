/*
 * Program ...... SinglePaint
 * File ......... Sketch.java
 * Author ....... Harald Hetzner
 * 
 * Copyright (C) 2006  Harald Hetzner
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110, USA
 * 
 * Harald Hetzner <singlepaint [at] mkultra [dot] dyndns [dot] org>
 */

package sp.graphics;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;

public class Sketch extends PaintJob {
	
	private Point p;
	
	public Sketch(BufferedImage image, Graphics2D graphics) {
		super(image, graphics);
	}
	
	public void drawPressed(Point p) {
		this.graphics.drawLine(p.x, p.y, p.x, p.y);
		this.p = p;
	}
	
	public void drawDragged(Point p) {
		this.graphics.drawLine(this.p.x, this.p.y, p.x, p.y);
		this.p = p;
	}
	
	public void drawReleased(Point p) {
		this.graphics.drawLine(this.p.x, this.p.y, p.x, p.y);
		this.p = null;
	}	
}