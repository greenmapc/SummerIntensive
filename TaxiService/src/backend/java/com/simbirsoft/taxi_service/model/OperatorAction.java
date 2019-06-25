package com.simbirsoft.taxi_service.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "operator_actions")
@Data
@NoArgsConstructor
public class OperatorAction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "action", nullable = false)
    private String action;

    @Column(name = "action_date")
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "operator_id", referencedColumnName = "id")
    private User operator;

}
