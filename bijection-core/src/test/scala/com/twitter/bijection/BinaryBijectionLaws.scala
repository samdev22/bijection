/*
Copyright 2012 Twitter, Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package com.twitter.bijection

import java.nio.ByteBuffer
import java.util.Arrays
import org.scalacheck.Properties
import org.scalacheck.Prop._

object BinaryBijectionLaws extends Properties("BinaryBijections")
with BaseProperties {
  def barrEq(a1: Array[Byte], a2: Array[Byte]) = Arrays.equals(a1, a2)

  property("rts Array[Byte] -> ByteBuffer") =
    roundTrips[Array[Byte], ByteBuffer](barrEq)
  property("rts Array[Byte] -> GZippedBytes") =
    roundTrips[Array[Byte], GZippedBytes](barrEq)
  property("rts Array[Byte] -> Base64String") =
    roundTrips[Array[Byte], Base64String](barrEq)
  property("rts Array[Byte] -> GZippedBase64String") =
    roundTrips[Array[Byte], GZippedBase64String](barrEq)
}
