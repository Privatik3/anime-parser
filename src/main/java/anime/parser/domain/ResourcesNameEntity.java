package anime.parser.domain;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "resources_name", schema = "", catalog = "my_db")
public class ResourcesNameEntity {

    private int id;
    private String name;
    private Collection<AnimeResourcesEntity> animeResourcesesById;
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
    @Column(name = "name", nullable = true, insertable = true, updatable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResourcesNameEntity that = (ResourcesNameEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "resourcesNameByResourcesNameId")
    public Collection<AnimeResourcesEntity> getAnimeResourcesesById() {
        return animeResourcesesById;
    }

    public void setAnimeResourcesesById(Collection<AnimeResourcesEntity> animeResourcesesById) {
        this.animeResourcesesById = animeResourcesesById;
    }

    @OneToMany(mappedBy = "resourcesNameByResourcesNameId")
    public Collection<StudioResoucesEntity> getStudioResoucesesById() {
        return studioResoucesesById;
    }

    public void setStudioResoucesesById(Collection<StudioResoucesEntity> studioResoucesesById) {
        this.studioResoucesesById = studioResoucesesById;
    }
}
