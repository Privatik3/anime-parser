package anime.parser.domain;

import javax.persistence.*;

@Entity
@Table(name = "connections", schema = "", catalog = "my_db")
public class ConnectionsEntity {

    private int id;
    private String idConnection;
    private String text;
    private int animesId;
    private AnimesEntity animesByAnimesId;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_connection", nullable = true, insertable = true, updatable = true, length = 45)
    public String getIdConnection() {
        return idConnection;
    }

    public void setIdConnection(String idConnection) {
        this.idConnection = idConnection;
    }

    @Basic
    @Column(name = "text", nullable = false, insertable = true, updatable = true, length = 255)
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Basic
    @Column(name = "animes_id", nullable = false, insertable = true, updatable = true)
    public int getAnimesId() {
        return animesId;
    }

    public void setAnimesId(int animesId) {
        this.animesId = animesId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConnectionsEntity that = (ConnectionsEntity) o;

        if (animesId != that.animesId) return false;
        if (id != that.id) return false;
        if (idConnection != null ? !idConnection.equals(that.idConnection) : that.idConnection != null) return false;
        if (text != null ? !text.equals(that.text) : that.text != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (idConnection != null ? idConnection.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + animesId;
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
}
