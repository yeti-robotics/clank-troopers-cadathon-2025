package frc.robot.subsystems.shooter;

import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.hardware.TalonFX;
import frc.robot.util.sim.PhysicsSim;

public class ShooterIOSim implements ShooterIO {
    private TalonFX feedMotor;
    private TalonFX flywheelMotor1;
    private TalonFX flywheelMotor2;

    public ShooterIOSim() {
        feedMotor = new TalonFX(ShooterConfigs.feederMotorID);
        flywheelMotor1 = new TalonFX(ShooterConfigs.fly1MotorID);
        flywheelMotor2 = new TalonFX(ShooterConfigs.fly2MotorID);

        flywheelMotor2.setControl(new Follower(flywheelMotor1.getDeviceID(), true));

        PhysicsSim.getInstance().addTalonFX(feedMotor);

        PhysicsSim.getInstance().addTalonFX(flywheelMotor1);
        PhysicsSim.getInstance().addTalonFX(flywheelMotor2);
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
