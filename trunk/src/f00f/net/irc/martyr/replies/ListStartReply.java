package f00f.net.irc.martyr.replies;

import f00f.net.irc.martyr.InCommand;

/**
 * Signals the beginning of a LIST response.
 *
 * @author Daniel Henninger
 */
public class ListStartReply extends GenericReply
{
    
    /**
	 * Factory constructor.
	 */
	public ListStartReply()
    {
	}

        @Override
    public String getIrcIdentifier()
    {
		return "321";
	}

        @Override
    public InCommand parse( String prefix, String identifier, String params )
    {
		return new ListStartReply();
	}

}

