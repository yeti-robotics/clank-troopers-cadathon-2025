package frc.robot.subsystems.shooter;

import com.ctre.phoenix6.controls.Follower;
import frc.robot.subsystems.shooter.ShooterIO;
import com.ctre.phoenix6.hardware.TalonFX;
import frc.robot.util.sim.PhysicsSim;

public class ShooterIOTalonFX implements ShooterIO {
    private TalonFX feedMotor;
    private TalonFX flywheelMotor1;
    private TalonFX flywheelMotor2;

    public ShooterIOTalonFX() {
        feedMotor = new TalonFX(ShooterConfigs.feederMotorID);
        flywheelMotor1 = new TalonFX(ShooterConfigs.fly1MotorID);
        flywheelMotor2 = new TalonFX(ShooterConfigs.fly2MotorID);

        flywheelMotor2.setControl(new Follower(flywheelMotor1.getDeviceID(), true));

    }

    public void updateInputs(ShooterIOInputs inputs) {
        inputs.feedSpeed = feedMotor.getVelocity().getValueAsDouble();
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