package roomescape.theme.domain;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import java.util.Objects;
import roomescape.reservation.domain.Reservation;

@Entity
public class Theme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private ThemeName name;
    @Embedded
    private ThemeDescription description;
    @Embedded
    private ThemeThumbnail thumbnail;
    @OneToMany(mappedBy = "theme")
    private List<Reservation> reservations;

    public Theme(Long id, String name, String description, String thumbnail) {
        this(Objects.requireNonNull(id),
                new ThemeName(name),
                new ThemeDescription(description),
                new ThemeThumbnail(thumbnail));
    }

    public Theme(String name, String description, String thumbnail) {
        this(null, new ThemeName(name), new ThemeDescription(description), new ThemeThumbnail(thumbnail));
    }

    private Theme(Long id, ThemeName name, ThemeDescription description, ThemeThumbnail thumbnail) {
        this.id = id;
        this.name = Objects.requireNonNull(name);
        this.description = Objects.requireNonNull(description);
        this.thumbnail = Objects.requireNonNull(thumbnail);
    }

    protected Theme() {
    }

    public Theme withId(Long id) {
        return new Theme(id, this.name, this.description, this.thumbnail);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name.name();
    }

    public String getDescription() {
        return description.description();
    }

    public String getThumbnail() {
        return thumbnail.thumbnail();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Theme theme = (Theme) object;
        return Objects.equals(id, theme.id)
               && Objects.equals(name, theme.name)
               && Objects.equals(description, theme.description)
               && Objects.equals(thumbnail, theme.thumbnail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, thumbnail);
    }
}
