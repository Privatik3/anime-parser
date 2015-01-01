package anime.parser.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "year_production", schema = "", catalog = "my_db")
public class YearProductionEntity {

    private int id;
    private Date begin;
    private Date ended;
    private Collection<AnimesEntity> animesesById;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "begin", nullable = false, insertable = true, updatable = true)
    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    @Basic
    @Column(name = "ended", nullable = true, insertable = true, updatable = true)
    public Date getEnded() {
        return ended;
    }

    public void setEnded(Date ended) {
        this.ended = ended;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        YearProductionEntity that = (YearProductionEntity) o;

        if (id != that.id) return false;
        if (begin != null ? !begin.equals(that.begin) : that.begin != null) return false;
        if (ended != null ? !ended.equals(that.ended) : that.ended != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (begin != null ? begin.hashCode() : 0);
        result = 31 * result + (ended != null ? ended.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "yearProductionByYearProductionId")
    public Collection<AnimesEntity> getAnimesesById() {
        return animesesById;
    }

    public void setAnimesesById(Collection<AnimesEntity> animesesById) {
        this.animesesById = animesesById;
    }
}
