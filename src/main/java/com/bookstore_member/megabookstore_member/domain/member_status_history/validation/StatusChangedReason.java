package com.bookstore_member.megabookstore_member.domain.member_status_history.validation;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
@NoArgsConstructor
@Getter
public class StatusChangedReason {
   private static final String STATUS_CHANGED_REASON_NOT_EMPTY ="상태 변경 사유는 빈값을 허용하지 않습니다.";
   @Column(nullable = false)
    private String statusChangedReason;
   public StatusChangedReason(Long statusChangedReason){
       validate(String.valueOf(statusChangedReason));
       this.statusChangedReason = String.valueOf(statusChangedReason);
   }
   private void validate(String statusChangedReason){
       validateStatusChangedReason(statusChangedReason);
   }
   private void validateStatusChangedReason(String statusChangedReason){
       if(Objects.isNull(statusChangedReason)||statusChangedReason.isEmpty()){
           throw new IllegalArgumentException(STATUS_CHANGED_REASON_NOT_EMPTY);
       }
   }
}
