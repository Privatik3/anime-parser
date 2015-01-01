package anime.parser.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "studio", schema = "", catalog = "my_db")
public class StudioEntity {

    private int id;
    private String name;
    private Date year;
    private String logo;
    private Collection<AnimesEntity> animesesById;
    private Collection<StudioResoucesEntity> studioResoucesesById;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, insertable = true, updatable = true, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "year", nullable = true, insertable = true, updatable = true)
    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    @Basic
    @Column(name = "logo", nullable = false, insertable = true, updatable = true, length = 255)
    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudioEntity that = (StudioEntity) o;

        if (id != that.id) return false;
        if (logo != null ? !logo.equals(that.logo) : that.logo != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (year != null ? !year.equals(that.year) : that.year != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        result = 31 * result + (logo != null ? logo.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "studioByStudioId")
    public Collection<AnimesEntity> getAnimesesById() {
        return animesesById;
    }

    public void setAnimesesById(Collection<AnimesEntity> animesesById) {
        this.animesesById = animesesById;
    }

    @OneToMany(mappedBy = "studioByStudioId")
    public Collection<StudioResoucesEntity> getStudioResoucesesById() {
        return studioResoucesesById;
    }

    public void setStudioResoucesesById(Collection<StudioResoucesEntity> studioResoucesesById) {
        this.studioResoucesesById = studioResoucesesById;
    }
}
