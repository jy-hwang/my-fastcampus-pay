package com.fastcampuspay.membership.adapter.in.web;

import com.fastcampuspay.common.WebAdapter;
import com.fastcampuspay.membership.application.port.in.ModifyMembershipCommand;
import com.fastcampuspay.membership.application.port.in.ModifyMembershipUseCase;
import com.fastcampuspay.membership.domain.Membership;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class ModifyMembershipContrller {

  private final ModifyMembershipUseCase modifyMembershipUseCase;

  @PatchMapping("/membership/modify")
  ResponseEntity<Membership> modifyMembershipByMemberId(@RequestBody ModifyMembershipRequest modifyMembershipRequest) {

    ModifyMembershipCommand command = ModifyMembershipCommand.builder()
            .membershipId(modifyMembershipRequest.getMembershipId())
            .name(modifyMembershipRequest.getName())
            .address(modifyMembershipRequest.getAddress())
            .email(modifyMembershipRequest.getEmail())
            .isValid(modifyMembershipRequest.isValid())
            .isCorp(modifyMembershipRequest.isCorp())
            .build();

    return ResponseEntity.ok(modifyMembershipUseCase.modifyMembership(command));

  }


}
