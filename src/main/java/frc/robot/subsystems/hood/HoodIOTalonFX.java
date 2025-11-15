package frc.robot.subsystems.hood;

import com.ctre.phoenix6.controls.MotionMagicTorqueCurrentFOC;
import com.ctre.phoenix6.hardware.TalonFX;

public class HoodIOTalonFX implements HoodIO {
    public final TalonFX hoodMotor;

    private final MotionMagicTorqueCurrentFOC magicRequest = new MotionMagicTorqueCurrentFOC(0);

    public HoodIOTalonFX() {
        hoodMotor = new TalonFX(HoodConfig.hoodMotorID);
        hoodMotor.getConfigurator().apply(HoodConfig.hoodTalonFXConfigs);
    }

    @Override
    public void updateInputs(HoodIOInputs inputs) {
        inputs.position = hoodMotor.getPosition().getValueAsDouble();
        inputs.targetPosition = hoodMotor.getClosedLoopReference().getValueAsDouble();
    }

    public void moveToPosition(double position) {
        hoodMotor.setControl(magicRequest.withPosition(position));
    }

    public double calcPosition(double distance) {
        return ((0.09 * distance) + 12);
    }
}
