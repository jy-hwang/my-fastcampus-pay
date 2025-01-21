package com.fastcampuspay.membership.application.service;

import com.fastcampuspay.common.UseCase;
import com.fastcampuspay.membership.adapter.out.persistence.MembershipJpaEntity;
import com.fastcampuspay.membership.adapter.out.persistence.MembershipMapper;
import com.fastcampuspay.membership.application.port.in.RegisterMembershipCommand;
import com.fastcampuspay.membership.application.port.in.RegisterMembershipUseCase;
import com.fastcampuspay.membership.application.port.out.RegisterMembershipPort;
import com.fastcampuspay.membership.domain.Membership;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
@Transactional
public class RegisterMembershipService implements RegisterMembershipUseCase {

  private final RegisterMembershipPort registerMembershipPort;

  private final MembershipMapper membershipMapper;

  @Override
  public Membership registerMembership(RegisterMembershipCommand command) {
    // ??
    // command -> DB

    // biz logic -> DB
    // external system
    // port, adapter

    MembershipJpaEntity jpaEntity = registerMembershipPort.createMembership(
            new Membership.MembershipName(command.getName())
            , new Membership.MembershipEmail(command.getEmail())
            , new Membership.MembershipAddress(command.getAddress())
            , new Membership.MembershipIsValid(command.isValid())
            , new Membership.MembershipIsCorp(command.isCorp())
    );
// entity -> Membership
    return MembershipMapper.mapToDomainEntity(jpaEntity);
  }
}
