package anime.parser.dao.implement;

import anime.parser.dao.AnimeDao;
import anime.parser.domain.*;
import anime.parser.utill.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

public class AnimeDaoImpl implements AnimeDao{

    @Override
    public void setAnimeInfoById(AnimesEntity animeInfoById, Session session) throws SQLException {
        try {
            session.beginTransaction();
            session.save(animeInfoById);
            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void setDirectedByDirectedId(DirectedEntity directedByDirectedId, Session session) throws SQLException {
        try {
            session.beginTransaction();
            session.save(directedByDirectedId);
            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void setStudioByStudioId(StudioEntity studioByStudioId, Session session) throws SQLException {
        try {
            session.beginTransaction();
            session.save(studioByStudioId);
            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void setYearProductionByYearProductionId(YearProductionEntity yearProductionByYearProductionId, Session session) throws SQLException {
        try {
            session.beginTransaction();
            session.save(yearProductionByYearProductionId);
            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void setAllScreenshotses(List<ScreenshotsEntity> screenshotses, Session session) throws SQLException {

        Transaction tx = session.beginTransaction();

        try {
            for (int i = 0; i < screenshotses.size(); i++) {
                session.save(screenshotses.get(i));

                if (i % 100 == 0) {
                    session.flush();
                    session.clear();
                }
            }

            tx.commit();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void setAllOtherTitles(List<OtherTitleEntity> otherTitles, Session session) throws SQLException {

        Transaction tx = session.beginTransaction();

        try {
            for (int i = 0; i < otherTitles.size(); i++) {
                session.save(otherTitles.get(i));

                if (i % 100 == 0) {
                    session.flush();
                    session.clear();
                }
            }

            tx.commit();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void setAllAnimeResources(List<AnimeResourcesEntity> animeResources, Session session) throws SQLException {

        Transaction tx = session.beginTransaction();

        try {
            for (int i = 0; i < animeResources.size(); i++) {
                session.save(animeResources.get(i));

                if (i % 100 == 0) {
                    session.flush();
                    session.clear();
                }
            }

            tx.commit();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void setAllConnections(List<ConnectionsEntity> connections, Session session) throws SQLException {

        Transaction tx = session.beginTransaction();

        try {
            for (int i = 0; i < connections.size(); i++) {
                session.save(connections.get(i));

                if (i % 100 == 0) {
                    session.flush();
                    session.clear();
                }
            }

            tx.commit();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void setAllGenres(List<AnimeGenreEntity> genres, Session session) throws SQLException {

        Transaction tx = session.beginTransaction();

        try {
            for (int i = 0; i < genres.size(); i++) {
                session.save(genres.get(i));

                if (i % 100 == 0) {
                    session.flush();
                    session.clear();
                }
            }

            tx.commit();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public DirectedEntity getDirectedEntityById(Integer getDirectedEntityById, Session session) throws SQLException {
        DirectedEntity directedEntity = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            directedEntity = (DirectedEntity) session.get(DirectedEntity.class, getDirectedEntityById);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return directedEntity;
    }

    @Override
    public GenresEntity getGenresEntityByID(Integer getGenresEntityById, Session session) throws SQLException {
        GenresEntity genresEntity = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            genresEntity = (GenresEntity) session.get(GenresEntity.class, getGenresEntityById);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return genresEntity;
    }

    @Override
    public ResourcesNameEntity getResourcesNameEntityById(Integer getResourcesNameById, Session session) throws SQLException {
        ResourcesNameEntity resourcesNameEntity = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            resourcesNameEntity = (ResourcesNameEntity) session.get(ResourcesNameEntity.class, getResourcesNameById);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resourcesNameEntity;
    }

    @Override
    public StudioEntity getStudioEntityById(Integer getStudioEntityById, Session session) throws SQLException {
        StudioEntity studioEntity = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            studioEntity = (StudioEntity) session.get(StudioEntity.class, getStudioEntityById);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studioEntity;
    }

    @Override
    public TypesEntity getTypesEntityById(Integer getTypesEntityById, Session session) throws SQLException {
        TypesEntity typesEntity = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            typesEntity = (TypesEntity) session.get(TypesEntity.class, getTypesEntityById);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return typesEntity;
    }
}
