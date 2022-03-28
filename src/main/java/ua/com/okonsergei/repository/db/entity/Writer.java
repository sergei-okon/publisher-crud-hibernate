package ua.com.okonsergei.repository.db.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "writers")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Writer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "writer_id")
    private Long id;

    @Column(name = "name", length = 45, nullable = false)
    private String name;

    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private List<Post> posts;
}
