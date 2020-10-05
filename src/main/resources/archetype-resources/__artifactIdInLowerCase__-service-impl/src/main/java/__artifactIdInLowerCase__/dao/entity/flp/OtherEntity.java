package ${groupId}.${artifactIdInLowerCase}.dao.entity.flp;

import javax.persistence.*;

@Entity
//@Table(name = "[insert table name]", schema = "[insert schema]")
public class OtherEntity {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "[insert primary key column]")
    public Integer id;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}