package chapter6

class UnitConversion(val factor: Double) {
  def convert(value: Double): Double = factor * value
}

class inchesToCentimeters extends UnitConversion(2.54)
class gallonsToLitres extends UnitConversion(3.78541178)
class milesToKilometers extends UnitConversion(1.609344)