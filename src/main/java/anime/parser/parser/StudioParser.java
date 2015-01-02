package anime.parser.parser;

import java.io.IOException;
import java.sql.Date;

public interface StudioParser {

    public String getStudioNameById(int studioId) throws IOException, Exception;
    public Date getStudioDateById(int studioId) throws Exception;
    public String getStudioLogoById(int studioId) throws Exception;
    public String getStudioResourcesById(int studioId) throws Exception;
}
