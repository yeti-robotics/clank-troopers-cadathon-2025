package frc.robot.subsystems.arm;

import edu.wpi.first.units.Units;
import edu.wpi.first.units.measure.Angle;

public enum ArmPosition {
    DOWN(0.0),
    STOWED(0.75);

    private Angle position;
    ArmPosition(double position) {
        this.position = Units.Rotations.of(position);
    }

    public Angle getPosition() {
        return position;
    }
}
