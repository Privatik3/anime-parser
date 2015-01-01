package anime.parser.domain;

import javax.persistence.*;

@Entity
@Table(name = "studio_resouces", schema = "", catalog = "my_db")
public class StudioResoucesEntity {

    private int id;
    private String resourcesUrl;
    private ResourcesNameEntity resourcesNameByResourcesNameId;
    private StudioEntity studioByStudioId;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "resources_url", nullable = true, insertable = true, updatable = true, length = 255)
    public String getResourcesUrl() {
        return resourcesUrl;
    }

    public void setResourcesUrl(String resourcesUrl) {
        this.resourcesUrl = resourcesUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudioResoucesEntity that = (StudioResoucesEntity) o;

        if (id != that.id) return false;
        if (resourcesUrl != null ? !resourcesUrl.equals(that.resourcesUrl) : that.resourcesUrl != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (resourcesUrl != null ? resourcesUrl.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "resources_name_id", referencedColumnName = "id", nullable = false)
    public ResourcesNameEntity getResourcesNameByResourcesNameId() {
        return resourcesNameByResourcesNameId;
    }

    public void setResourcesNameByResourcesNameId(ResourcesNameEntity resourcesNameByResourcesNameId) {
        this.resourcesNameByResourcesNameId = resourcesNameByResourcesNameId;
    }

    @ManyToOne
    @JoinColumn(name = "studio_id", referencedColumnName = "id", nullable = false)
    public StudioEntity getStudioByStudioId() {
        return studioByStudioId;
    }

    public void setStudioByStudioId(StudioEntity studioByStudioId) {
        this.studioByStudioId = studioByStudioId;
    }
}
