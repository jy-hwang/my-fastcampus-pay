package com.fastcampuspay.membership.application.service;

import com.fastcampuspay.common.UseCase;
import com.fastcampuspay.membership.adapter.out.persistence.MembershipJpaEntity;
import com.fastcampuspay.membership.adapter.out.persistence.MembershipMapper;
import com.fastcampuspay.membership.application.port.in.ModifyMembershipCommand;
import com.fastcampuspay.membership.application.port.in.ModifyMembershipUseCase;
import com.fastcampuspay.membership.application.port.out.ModifyMembershipPort;
import com.fastcampuspay.membership.domain.Membership;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
@Transactional
public class ModifyMembershipService implements ModifyMembershipUseCase {

  private final ModifyMembershipPort modifyMembershipPort;

  private final MembershipMapper membershipMapper;

  @Override
  public Membership modifyMembership(ModifyMembershipCommand command) {
    // ??
    // command -> DB

    // biz logic -> DB
    // external system
    // port, adapter

    MembershipJpaEntity jpaEntity = modifyMembershipPort.modifyMembership(
            new Membership.MembershipId(command.getMembershipId())
            , new Membership.MembershipName(command.getName())
            , new Membership.MembershipEmail(command.getEmail())
            , new Membership.MembershipAddress(command.getAddress())
            , new Membership.MembershipIsValid(command.isValid())
            , new Membership.MembershipIsCorp(command.isCorp())
    );
// entity -> Membership
    return MembershipMapper.mapToDomainEntity(jpaEntity);
  }
}
