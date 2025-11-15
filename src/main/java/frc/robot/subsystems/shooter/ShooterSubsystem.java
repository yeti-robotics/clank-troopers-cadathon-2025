package frc.robot.subsystems.shooter;

import static edu.wpi.first.wpilibj2.command.Commands.runEnd;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {

    private ShooterIO io;
    private ShooterIOInputsAutoLogged inputs = new ShooterIOInputsAutoLogged();

    @Override
    public void periodic() {
        io.updateInputs(inputs);
    }

    public ShooterSubsystem(ShooterIO io) {
        this.io = io;
    }

    public Command startFeeders(double feedSpeed) {
        return runEnd(() -> io.setFeedSpeed(feedSpeed), () -> io.setFeedSpeed(0));
    }

    public Command startFlywheels(double speed) {
        return run(() -> io.setFlywheels(speed));
    }

    public Command stopFlywheels() {
        return run(() -> io.setFlywheels(0));
    }
}
