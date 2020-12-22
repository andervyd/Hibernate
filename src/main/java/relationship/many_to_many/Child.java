package relationship.many_to_many;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "children")
public class Child {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String firstName;

    @Column(name = "age")
    private int age;

    @ManyToMany(cascade = {CascadeType.PERSIST,
                              CascadeType.REFRESH,
                                 CascadeType.MERGE,
                                    CascadeType.DETACH})
    @JoinTable(name = "child_section",
                  joinColumns = @JoinColumn(name = "child_id"),
                     inverseJoinColumns = @JoinColumn(name = "section_id"))
    private List<Section> sectionList;


    public Child() {
        // default
    }

    public Child(String firstName, int age) {
        this.firstName = firstName;
        this.age = age;
    }


    public void addSectionToChild(Section sections) {
        if(sectionList == null) {
            sectionList = new ArrayList<>();
        }

        sectionList.add(sections);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Section> getSectionList() {
        return sectionList;
    }

    public void setSectionList(List<Section> sectionList) {
        this.sectionList = sectionList;
    }


    public String toString() {
        return "Child [ id: " + id +
                ", name: " + firstName +
                ", age: " + age + " ]";
    }
}