package frc.robot.subsystems.shooter;

import com.ctre.phoenix6.hardware.TalonFX;
import frc.robot.subsystems.intake.IntakeIO;
import frc.robot.util.sim.PhysicsSim;

public class ShooterIOSim implements IntakeIO {
    private TalonFX feedMotor;
    private TalonFX flywheelMotor1;
    private TalonFX flywheelMotor2;


    public ShooterIOSim() {
        feedMotor = new TalonFX(ShooterConfigs.feederMotorID);
        PhysicsSim.getInstance().addTalonFX(feedMotor);
    }

    public void updateInputs(ShooterIO.ShooterIOInputs inputs) {
        inputs.feedSpeed = feedMotor.getVelocity().getValueAsDouble();
        inputs.flywheelSpeed = flywheelMotor1.getVelocity().getValueAsDouble();
    }

    @Override
    public void setFeedSpeed(double feedSpeed) {
        feedMotor.set(feedSpeed);
    }

    @Override
    public void setFlywheels(double flySpeed) {
        flywheelMotor1.set(flySpeed);
    }
}
