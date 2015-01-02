package anime.parser.parser;

import java.io.IOException;
import java.sql.Date;

public interface StudioParser {

    public String getStudioNameById(int studioId) throws IOException;
    public Date getStudioDateById(int studioId) throws IOException;
    public String getStudioLogoById(int studioId) throws IOException;
    public String getStudioResourcesById(int studioId) throws IOException;
}
