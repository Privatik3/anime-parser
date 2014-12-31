package anime.parser.domain;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "second_name", schema = "", catalog = "mydb")
public class SecondNameEntity {

    private int id;
    private String name;
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

        SecondNameEntity that = (SecondNameEntity) o;

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

    @OneToMany(mappedBy = "secondNameByOtherTitleId")
    public Collection<AnimesEntity> getAnimesesById() {
        return animesesById;
    }

    public void setAnimesesById(Collection<AnimesEntity> animesesById) {
        this.animesesById = animesesById;
    }
}
