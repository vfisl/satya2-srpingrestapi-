package com.leagueapp.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Fixures")
public class Fixures {
private String squads;
@Id
@GeneratedValue(generator = "fixure_gen",strategy = GenerationType.AUTO)
@SequenceGenerator(name="fixure_gen",sequenceName = "fixure_seq",initialValue = 11,allocationSize = 2)
private Integer fixureId;
private String stadium;
//@ManyToOne
//@JoinColumn(name="league_id")
//private League league;

//@OneToMany(cascade =CascadeType.ALL,fetch = FetchType.EAGER)
//@JoinColumn
//private Set<Team> teams;
//}
}