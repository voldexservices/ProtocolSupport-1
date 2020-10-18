package protocolsupport.protocol.typeremapper.entity.metadata.types.object.minecart;

import protocolsupport.protocol.typeremapper.entity.metadata.object.value.NetworkEntityMetadataObjectIndexValueBooleanToByteTransformer;
import protocolsupport.protocol.typeremapper.entity.metadata.object.value.NetworkEntityMetadataObjectIndexValueNoOpTransformer;
import protocolsupport.protocol.types.networkentity.metadata.NetworkEntityMetadataObjectIndex;
import protocolsupport.protocol.utils.ProtocolVersionsHelper;

public class MinecartFurnaceNetworkEntityMetadataFormatTransformerFactory extends MinecartNetworkEntityMetadataFormatTransformerFactory {

	public static final MinecartFurnaceNetworkEntityMetadataFormatTransformerFactory INSTANCE = new MinecartFurnaceNetworkEntityMetadataFormatTransformerFactory();

	protected MinecartFurnaceNetworkEntityMetadataFormatTransformerFactory() {
		addTransformer(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.MinecartFurnace.POWERED, 12), ProtocolVersionsHelper.RANGE__1_10__1_13_2);
		addTransformer(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.MinecartFurnace.POWERED, 11), ProtocolVersionsHelper.ALL_1_9);
		addTransformer(new NetworkEntityMetadataObjectIndexValueBooleanToByteTransformer(NetworkEntityMetadataObjectIndex.MinecartFurnace.POWERED, 16), ProtocolVersionsHelper.DOWN_1_8);
	}

}