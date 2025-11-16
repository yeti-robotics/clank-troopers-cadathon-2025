package frc.robot.subsystems.arm;

import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.controls.MotionMagicTorqueCurrentFOC;
import com.ctre.phoenix6.hardware.TalonFX;

public class ArmIOTalonFX implements ArmIO {
    private final TalonFX armMotorMain;
    private final TalonFX armMotorFollow;

    private final MotionMagicTorqueCurrentFOC magicRequest = new MotionMagicTorqueCurrentFOC(0);

    public ArmIOTalonFX() {
        armMotorMain = new TalonFX(ArmConfig.MAIN_ARM_MOTOR_ID);
        armMotorFollow = new TalonFX(ArmConfig.FOLLOW_ARM_MOTOR_ID);

        armMotorFollow.setControl(new Follower(ArmConfig.MAIN_ARM_MOTOR_ID, true));
    }

    @Override
    public void updateInputs(ArmIOInputs inputs) {
        inputs.positionDegCurrent = armMotorMain.getPosition().getValueAsDouble();
        inputs.positionDegTarget = armMotorMain.getClosedLoopReference().getValueAsDouble();
    }

    @Override
    public void moveToPosition(double position) {
        armMotorMain.setControl(magicRequest.withPosition(position));
    }


}