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
    public void setSecondNameByOtherTitleId(ScreenshotsEntity secondNameByOtherTitleId) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(secondNameByOtherTitleId);
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
}
