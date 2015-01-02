package anime.parser.dao.implement;

import anime.parser.dao.AnimeDao;
import anime.parser.domain.*;
import anime.parser.utill.HibernateUtil;
import org.hibernate.Session;

import java.sql.SQLException;

public class AnimeDaoImpl implements AnimeDao{

    @Override
    public void setAnimeInfoById(AnimesEntity animeInfoById) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(animeInfoById);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
    }

    @Override
    public void setAnimesGanresById(AnimeGenreEntity animesGanresById) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(animesGanresById);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
    }

    @Override
    public void setAnimeResourcesesById(AnimeResourcesEntity animeResourcesesById) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(animeResourcesesById);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if ((session != null) && (session.isOpen())) session.close();
        }

    }

    @Override
    public void setDirectedByDirectedId(DirectedEntity directedByDirectedId) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(directedByDirectedId);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if ((session != null) && (session.isOpen())) session.close();
        }

    }

    @Override
    public void setGenresById(GenresEntity genresById) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(genresById);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
    }

    @Override
    public void setResourcesNameById(ResourcesNameEntity resourcesNameById) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(resourcesNameById);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
    }

    @Override
    public void setSecondNameById(OtherTitleEntity secondNameById) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(secondNameById);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
    }

    @Override
    public void setStudioByStudioId(StudioEntity studioByStudioId) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(studioByStudioId);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if ((session != null) && (session.isOpen())) session.close();
        }

    }

    @Override
    public void setAnimeTypesByAnimeTypeId(TypesEntity animeTypesByAnimeTypeId) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(animeTypesByAnimeTypeId);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if ((session != null) && (session.isOpen())) session.close();
        }

    }

    @Override
    public void setYearProductionByYearProductionId(YearProductionEntity yearProductionByYearProductionId) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(yearProductionByYearProductionId);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
    }

    @Override
    public void setConnectionsesById(ConnectionsEntity connectionsesById) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(connectionsesById);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
    }

    @Override
    public void setScreenshotsesById(ScreenshotsEntity screenshotsesById) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(screenshotsesById);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
    }

    @Override
    public AnimesEntity getAnimesByID(Integer getAnimesById) throws SQLException {
            Session session = null;
            AnimesEntity animesEntity = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                animesEntity = (AnimesEntity) session.get(AnimesEntity.class, getAnimesById);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
            return animesEntity;
    }

    @Override
    public AnimeGenreEntity getAnimeGenreEntityById(Integer getAnimeGenreEntityById) throws SQLException {
        Session session = null;
        AnimeGenreEntity animeGenreEntity = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            animeGenreEntity = (AnimeGenreEntity) session.get(AnimesEntity.class, getAnimeGenreEntityById);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return animeGenreEntity;
    }

    @Override
    public AnimeResourcesEntity getAnimeResourcesEntityById(Integer getAnimeResourcesEntityByID) throws SQLException {
        Session session = null;
        AnimeResourcesEntity animeResourcesEntity = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            animeResourcesEntity = (AnimeResourcesEntity) session.get(AnimesEntity.class, getAnimeResourcesEntityByID);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return animeResourcesEntity;
    }

    @Override
    public ConnectionsEntity getConnectionsEntityByID(Integer getConnectionsEntityById) throws SQLException {
        Session session = null;
        ConnectionsEntity connectionsEntity = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            connectionsEntity = (ConnectionsEntity) session.get(AnimesEntity.class, getConnectionsEntityById);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return connectionsEntity;
    }

    @Override
    public DirectedEntity getDirectedEntityById(Integer getDirectedEntityById) throws SQLException {
        Session session = null;
        DirectedEntity directedEntity = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            directedEntity = (DirectedEntity) session.get(AnimesEntity.class, getDirectedEntityById);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return directedEntity;
    }

    @Override
    public GenresEntity getGenresEntityByID(Integer getGenresEntityById) throws SQLException {
        Session session = null;
        GenresEntity genresEntity = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            genresEntity = (GenresEntity) session.get(AnimesEntity.class, getGenresEntityById);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return genresEntity;
    }

    @Override
    public OtherTitleEntity getOtherTitleEntityById(Integer getOtherTitleEntityById) throws SQLException {
        Session session = null;
        OtherTitleEntity otherTitleEntity = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            otherTitleEntity = (OtherTitleEntity) session.get(AnimesEntity.class, getOtherTitleEntityById);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return otherTitleEntity;
    }

    @Override
    public ResourcesNameEntity getResourcesNameEntityById(Integer getResourcesNameById) throws SQLException {
        Session session = null;
        ResourcesNameEntity resourcesNameEntity = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            resourcesNameEntity = (ResourcesNameEntity) session.get(AnimesEntity.class, getResourcesNameById);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return resourcesNameEntity;
    }

    @Override
    public ScreenshotsEntity getScreenshotsEntityById(Integer getScreenshotsEntityById) throws SQLException {
        Session session = null;
        ScreenshotsEntity screenshotsEntity = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            screenshotsEntity = (ScreenshotsEntity) session.get(AnimesEntity.class, getScreenshotsEntityById);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return screenshotsEntity;
    }

    @Override
    public StudioEntity getStudioEntityById(Integer getStudioEntityById) throws SQLException {
        Session session = null;
        StudioEntity studioEntity = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            studioEntity = (StudioEntity) session.get(AnimesEntity.class, getStudioEntityById);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return studioEntity;
    }

    @Override
    public TypesEntity getTypesEntityById(Integer getTypesEntityById) throws SQLException {
        Session session = null;
        TypesEntity typesEntity = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            typesEntity = (TypesEntity) session.get(AnimesEntity.class, getTypesEntityById);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return typesEntity;
    }

    @Override
    public YearProductionEntity getYearProductionEntityById(Integer getYearProductionEntityById) throws SQLException {
        Session session = null;
        YearProductionEntity yearProductionEntity = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            yearProductionEntity = (YearProductionEntity) session.get(AnimesEntity.class, getYearProductionEntityById);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return yearProductionEntity;
    }
}
