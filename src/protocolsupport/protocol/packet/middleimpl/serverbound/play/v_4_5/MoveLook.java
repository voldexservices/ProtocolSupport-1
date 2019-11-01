package protocolsupport.protocol.packet.middleimpl.serverbound.play.v_4_5;

import io.netty.buffer.ByteBuf;
import protocolsupport.protocol.ConnectionImpl;
import protocolsupport.protocol.packet.middle.serverbound.play.MiddleLook;
import protocolsupport.protocol.packet.middleimpl.IPacketData;
import protocolsupport.protocol.packet.middleimpl.serverbound.play.v_4_5_6_7_8.AbstractMoveLook;
import protocolsupport.utils.recyclable.RecyclableCollection;
import protocolsupport.utils.recyclable.RecyclableSingletonList;

public class MoveLook extends AbstractMoveLook {

	public MoveLook(ConnectionImpl connection) {
		super(connection);
	}

	protected double yhead;

	@Override
	public void readFromClientData(ByteBuf clientdata) {
		x = clientdata.readDouble();
		y = clientdata.readDouble();
		yhead = clientdata.readDouble();
		z = clientdata.readDouble();
		yaw = clientdata.readFloat();
		pitch = clientdata.readFloat();
		onGround = clientdata.readBoolean();
	}

	@Override
	public RecyclableCollection<? extends IPacketData> toNative() {
		if ((y == -999.0D) && (yhead == -999.0D)) {
			return RecyclableSingletonList.create(MiddleLook.create(yaw, pitch, onGround));
		} else {
			return super.toNative();
		}
	}

}
