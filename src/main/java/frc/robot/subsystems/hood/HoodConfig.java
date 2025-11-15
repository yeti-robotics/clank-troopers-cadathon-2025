package frc.robot.subsystems.hood;

import com.ctre.phoenix6.configs.*;
import com.ctre.phoenix6.signals.GravityTypeValue;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;
import frc.robot.Robot;

public class HoodConfig {
    static final int hoodMotorID = 15;

    private static final Slot0Configs SLOT_0_CONFIGS = Robot.isReal()
            ? new Slot0Configs()
                    .withKP(0)
                    .withKI(0)
                    .withKD(0)
                    .withKG(0)
                    .withKV(0)
                    .withKA(0)
                    .withKS(0)
                    .withGravityType(GravityTypeValue.Arm_Cosine)
            : new Slot0Configs();

    static final TalonFXConfiguration hoodTalonFXConfigs = new TalonFXConfiguration()
            .withSlot0(SLOT_0_CONFIGS)
            .withMotionMagic(new MotionMagicConfigs()
                    .withMotionMagicAcceleration(0)
                    .withMotionMagicCruiseVelocity(0)
                    .withMotionMagicJerk(0))
            .withFeedback(new FeedbackConfigs().withRotorToSensorRatio(1).withSensorToMechanismRatio(1))
            .withMotorOutput(new MotorOutputConfigs()
                    .withInverted(InvertedValue.CounterClockwise_Positive)
                    .withNeutralMode(NeutralModeValue.Brake));
}
