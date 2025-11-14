package frc.robot.subsystems.shooter;

import edu.wpi.first.wpilibj2.command.Command;

import static edu.wpi.first.wpilibj2.command.Commands.runEnd;

public class ShooterSubsystem {

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

    public Command runFlywheels(double speed) {
        return runEnd(() -> io.setFlywheels(speed), () -> io.setFlywheels(0));
    }
}
