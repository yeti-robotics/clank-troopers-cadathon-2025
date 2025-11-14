package frc.robot.subsystems.intake;

import com.ctre.phoenix6.hardware.CANrange;
import com.ctre.phoenix6.hardware.TalonFX;
import frc.robot.util.sim.PhysicsSim;

public class IntakeIOTalonFX implements IntakeIO {
    private TalonFX intakeMotor;

    public IntakeIOTalonFX() {
        intakeMotor = new TalonFX(IntakeConfig.intakeMotorID);

    }

    public void updateInputs(IntakeIOInputs inputs) {
        inputs.rollerVelocity = intakeMotor.getVelocity().getValueAsDouble();
    }

    @Override
    public void setPower(double scorePower) {
        intakeMotor.set(scorePower);
    }
}