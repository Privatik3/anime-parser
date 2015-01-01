package anime.parser.domain;

import javax.persistence.*;

@Entity
@Table(name = "anime_genre", schema = "", catalog = "my_db")
public class AnimeGenreEntity {

    private int id;
    private int animesId;
    private int genresId;
    private AnimesEntity animesByAnimesId;
    private GenresEntity genresByGenresId;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "animes_id", nullable = false, insertable = true, updatable = true)
    public int getAnimesId() {
        return animesId;
    }

    public void setAnimesId(int animesId) {
        this.animesId = animesId;
    }

    @Basic
    @Column(name = "genres_id", nullable = false, insertable = true, updatable = true)
    public int getGenresId() {
        return genresId;
    }

    public void setGenresId(int genresId) {
        this.genresId = genresId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AnimeGenreEntity that = (AnimeGenreEntity) o;

        if (animesId != that.animesId) return false;
        if (genresId != that.genresId) return false;
        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + animesId;
        result = 31 * result + genresId;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "animes_id", referencedColumnName = "id", nullable = false)
    public AnimesEntity getAnimesByAnimesId() {
        return animesByAnimesId;
    }

    public void setAnimesByAnimesId(AnimesEntity animesByAnimesId) {
        this.animesByAnimesId = animesByAnimesId;
    }

    @ManyToOne
    @JoinColumn(name = "genres_id", referencedColumnName = "id", nullable = false)
    public GenresEntity getGenresByGenresId() {
        return genresByGenresId;
    }

    public void setGenresByGenresId(GenresEntity genresByGenresId) {
        this.genresByGenresId = genresByGenresId;
    }
}
