package frc.robot.subsystems.arm;

import edu.wpi.first.units.Units;
import edu.wpi.first.units.measure.Angle;

public enum ArmPosition {
    DOWN(0.0),
    STOWED(0.75);

    private Angle height;
    ArmPosition(double height) {
        this.height = Units.Rotations.of(height);

    public Angle get_height() {
        return height;
        }
}
