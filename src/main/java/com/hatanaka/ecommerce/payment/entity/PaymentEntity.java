package com.hatanaka.ecommerce.payment.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity // para entender que é uma entidade
@Audited
@EntityListeners(AuditingEntityListener.class)
@Builder 
@Data // cria um Getter, Setter, Construtor, ToString, EqualsAndHashCode
@AllArgsConstructor // os construtores vão existir em tempo de compilação
@NoArgsConstructor // caso não tenha nenhum argumento vai criar um construtor
public class PaymentEntity {

    @Id
    @GeneratedValue // indica que o id vai ser gerado pelo provedor de persistência, é adicionado logo após o id
    private Long id;

    @Column // informa a configuração da coluna da tabela
    private String code;

    @Column
    private String checkoutCode;

    @CreatedDate // cria uma data
    private LocalDateTime createdAt;

    @LastModifiedDate // pega a última data modificada
    private LocalDateTime updatedAt;
}
