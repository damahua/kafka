/**
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements. See the NOTICE
 * file distributed with this work for additional information regarding copyright ownership. The ASF licenses this file
 * to You under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package kafka.api

import org.apache.kafka.common.requests.HeartbeatResponse
import java.nio.ByteBuffer

object HeartbeatResponseAndHeader {
  def readFrom(buffer: ByteBuffer): HeartbeatResponseAndHeader = {
    val correlationId = buffer.getInt
    val body = HeartbeatResponse.parse(buffer)
    new HeartbeatResponseAndHeader(correlationId, body)
  }
}

case class HeartbeatResponseAndHeader(override val correlationId: Int, override val body: HeartbeatResponse)
  extends GenericResponseAndHeader(correlationId, body, RequestKeys.nameForKey(RequestKeys.HeartbeatKey), None) {
}
