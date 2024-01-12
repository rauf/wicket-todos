package in.rauf.entities;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "properties")
public class PropertyEntity extends BaseEntity {

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL)
    private List<TaskEntity> projects;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TaskEntity> getProjects() {
        return projects;
    }

    public void setProjects(List<TaskEntity> projects) {
        this.projects = projects;
    }

}

