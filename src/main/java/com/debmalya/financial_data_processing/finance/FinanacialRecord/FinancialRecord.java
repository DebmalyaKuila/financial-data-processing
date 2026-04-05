package com.debmalya.financial_data_processing.finance.FinanacialRecord;

import com.debmalya.financial_data_processing.auth.enums.RecordType;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.debmalya.financial_data_processing.finance.Category.Category;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "financial_records",
       indexes = {
           @Index(name = "idx_FinancialRecord_type", columnList = "type"),
           @Index(name = "idx_FinancialRecord_category", columnList = "category_id"),
           @Index(name = "idx_FinancialRecord_created_by", columnList = "created_by")
        }
)
@Data
@EntityListeners(AuditingEntityListener.class)
public class FinancialRecord {
    @Id
    @GeneratedValue
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    private UUID id;

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal amount=BigDecimal.ZERO; // by default amout is zero

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", 
                nullable = false,
                foreignKey = @ForeignKey(name = "fk_financial_record_category")
    )
    private Category category;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private RecordType type;

    @Column(nullable = false)
    private String note="";

    //auditing data
    @Column(name = "created_at", nullable = false, updatable = false)
    @CreatedDate
    private Instant createdAt;

    @Column(name = "updated_at", nullable = false)
    @LastModifiedDate
    private Instant updatedAt;

    @Column(name = "created_by", nullable = false, updatable = false)
    @CreatedBy
    private UUID createdBy;

    @Column(name = "updated_by", nullable = false)
    @LastModifiedBy
    private UUID updatedBy;

    //soft deleting
    @Column(nullable = false)
    private Boolean isDeleted=false;

}
