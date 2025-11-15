package frc.robot.subsystems.hood;

import com.ctre.phoenix6.controls.MotionMagicTorqueCurrentFOC;
import com.ctre.phoenix6.hardware.TalonFX;
import frc.robot.util.sim.PhysicsSim;

public class HoodIOSim implements HoodIO {
    public final TalonFX hoodMotor;

    private final MotionMagicTorqueCurrentFOC magicRequest = new MotionMagicTorqueCurrentFOC(0);

    public HoodIOSim() {
        hoodMotor = new TalonFX(HoodConfig.hoodMotorID);
        PhysicsSim.getInstance().addTalonFX(hoodMotor);
    }

    @Override
    public void updateInputs(HoodIOInputs inputs) {
        inputs.position = hoodMotor.getPosition().getValueAsDouble();
        inputs.targetPosition = hoodMotor.getClosedLoopReference().getValueAsDouble();
    }

    public void moveToPosition(double position) {
        hoodMotor.setControl(magicRequest.withPosition(position));
    }
}
