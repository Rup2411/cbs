package com.busybox.cbs.dto.request;

import java.util.Optional;
import java.util.function.Consumer;

import com.busybox.cbs.exception.DeatilsNullOrMissingException;
import com.busybox.cbs.model.Fees_SettingDetails;
import com.busybox.cbs.model.MemberDetails;
import com.busybox.cbs.model.NomineeDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberRequestDto {

    private MemberDetails memberDetails;
    private NomineeDetails nomineeDetails;
    private Fees_SettingDetails fees_SettingDetails;

    public void validateAndExtractDetails(
            Consumer<MemberDetails> memberAction,
            Consumer<NomineeDetails> nomineeAction,
            Consumer<Fees_SettingDetails> feesAction) {
        
        Optional.ofNullable(getMemberDetails())
            .ifPresentOrElse(memberAction, () -> {
                throw new DeatilsNullOrMissingException("Member Details Missing");
            });

        Optional.ofNullable(getNomineeDetails())
            .ifPresentOrElse(nomineeAction, () -> {
                throw new DeatilsNullOrMissingException("Nominee Details Missing");
            });

        Optional.ofNullable(getFees_SettingDetails())
            .ifPresentOrElse(feesAction, () -> {
                throw new DeatilsNullOrMissingException("Fees Setting Details Missing");
            });
    }
}
