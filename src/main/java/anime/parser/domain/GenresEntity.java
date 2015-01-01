package anime.parser.domain;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "genres", schema = "", catalog = "my_db")
public class GenresEntity {

    private int id;
    private String name;
    private Collection<AnimeGenreEntity> animeGenresById;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, insertable = true, updatable = true, length = 255)
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

        GenresEntity that = (GenresEntity) o;

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

    @OneToMany(mappedBy = "genresByGenresId")
    public Collection<AnimeGenreEntity> getAnimeGenresById() {
        return animeGenresById;
    }

    public void setAnimeGenresById(Collection<AnimeGenreEntity> animeGenresById) {
        this.animeGenresById = animeGenresById;
    }
}
