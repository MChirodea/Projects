package model;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Entity
@Table( name = "REPORT" )
public class Report {

    private Long id;

    private User uid;

    private String drug;

    private Integer amount;


    public Report(){

    }

    public Report(User uid, String drug, Integer amount){
     this.amount = amount;
     this.drug = drug;
     this.uid = uid;

    }
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToOne
    @JoinColumn(name = "uid")
    public User getUid() {
        return uid;
    }

    public void setUid(User uid) {
        this.uid = uid;
    }

    public String getDrug() {
        return drug;
    }

    public void setDrug(String drug) {
        this.drug = drug;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
