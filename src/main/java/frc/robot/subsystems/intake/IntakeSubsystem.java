package frc.robot.subsystems.intake;

import edu.wpi.first.wpilibj2.command.Command;
import org.littletonrobotics.junction.Logger;

import static edu.wpi.first.wpilibj2.command.Commands.runEnd;

public class IntakeSubsystem {
    private IntakeIO io;
    private IntakeIOInputsAutoLogged inputs = new IntakeIOInputsAutoLogged();

    public IntakeSubsystem(IntakeIO io) {
        this.io = io;
    }

    @Override
    public void periodic() {
        io.updateInputs(inputs);
        Logger.processInputs("Scoring Mechanism", inputs);
    }

    public Command rollIn(double power) {
        return runEnd(() -> io.setPower(power), () -> io.setPower(0));
    }
}
