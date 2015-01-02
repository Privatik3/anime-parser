package anime.parser.parser;

import java.sql.Date;

public interface StudioParser {

    public String getStudioNameById(int studioId);
    public Date getStudioDateById(int studioId);
    public String getStudioLogoById(int studioId);
}
