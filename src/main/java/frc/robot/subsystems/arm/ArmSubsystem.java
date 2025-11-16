package frc.robot.subsystems.arm;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArmSubsystem extends SubsystemBase {

    private ArmIO io;
    private ArmIOInputsAutoLogged inputs = new ArmIOInputsAutoLogged();

    @Override
    public void periodic() {
        io.updateInputs(inputs);
    }

    public ArmSubsystem(ArmIO io) {
        this.io = io;
    }

    public Command moveToPosition(double position) {
        return run(() -> io.moveToPosition(position));
    }
}
