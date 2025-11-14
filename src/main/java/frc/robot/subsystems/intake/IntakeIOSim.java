package frc.robot.subsystems.intake;


import com.ctre.phoenix6.hardware.CANrange;
import com.ctre.phoenix6.hardware.TalonFX;
import frc.robot.util.sim.PhysicsSim;

public class IntakeIOSim implements IntakeIO {
    private TalonFX intakeMotor;

    public IntakeIOSim() {
        intakeMotor = new TalonFX(IntakeConfig.intakeMotorID);
        PhysicsSim.getInstance().addTalonFX(intakeMotor);
    }

    public void updateInputs(IntakeIOInputs inputs) {
        inputs.rollerVelocity = intakeMotor.getVelocity().getValueAsDouble();
    }

    @Override
    public void setPower(double scorePower) {
        intakeMotor.set(scorePower);
    }
}