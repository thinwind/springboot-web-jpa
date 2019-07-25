package win.shangyh.demo.sbwebjpa.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import win.shangyh.demo.sbwebjpa.domain.Consts;

/**
 * User
 */
@Setter
@Getter
@Entity
public class User {

    @Id
    @GeneratedValue(generator = Consts.ENTITY_ID_GENERATOR)
    private Long id;

    private String name;

    private String tel;
}