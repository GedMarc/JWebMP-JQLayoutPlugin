package za.co.mmagon.jwebswing.plugins.jquerylayout.layout.options;

import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * The default responsive options
 *
 * @param <J>
 * 		always this
 *
 * @since 2018/01/27
 */
public class JQLayoutResponsiveOptions<J extends JQLayoutResponsiveOptions<J>> extends JavaScriptPart<J>
{
	private Boolean enabled;
	private LayoutResponsiveSize when;

	private Map<LayoutResponsiveSize, Integer> sizes;

	/**
	 * Creates a new responsive object with the given parameters
	 *
	 * @param enabled
	 * 		if this object is enabled
	 * @param when
	 * 		when the object must transform
	 * @param sizes
	 * 		a map of sizes to the trasform
	 * 		<p>
	 * 		default
	 * 		, sizes: {
	 * 		xl: 1140,
	 * 		lg: 992,
	 * 		md: 768,
	 * 		sm: 576,
	 * 		xs: 0
	 * 		}
	 */
	public JQLayoutResponsiveOptions(Boolean enabled, LayoutResponsiveSize when, SortedMap<LayoutResponsiveSize, Integer> sizes)
	{
		this();
		this.enabled = enabled;
		this.when = when;
		this.sizes = sizes;
	}

	/**
	 * Created a new responsive options object
	 * <p>
	 * default sizes
	 * <p>
	 * <p>
	 * default
	 * , sizes: {
	 * xl: 1140,
	 * lg: 992,
	 * md: 768,
	 * sm: 576,
	 * xs: 0
	 * }
	 */

	public JQLayoutResponsiveOptions()
	{
		//No config needed
	}

	/**
	 * Gets if the responsive feature is enabled
	 *
	 * @return
	 */
	public Boolean getEnabled()
	{
		return enabled;
	}

	/**
	 * Sets if the responsive feature is enabled
	 *
	 * @param enabled
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setEnabled(@Nullable Boolean enabled)
	{
		this.enabled = enabled;
		return (J) this;
	}

	/**
	 * Gets when the sizes of the obejct responds
	 *
	 * @return
	 */
	public LayoutResponsiveSize getWhen()
	{
		return when;
	}

	/**
	 * Sets when the sizes of the object respond
	 *
	 * @param when
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setWhen(@Nullable LayoutResponsiveSize when)
	{
		this.when = when;
		return (J) this;
	}

	/**
	 * Returns a tree map if wasn't set
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public Map<LayoutResponsiveSize, Integer> getSizes()
	{
		if (sizes == null)
		{
			sizes = new TreeMap<>();
		}
		return sizes;
	}

	/**
	 * Sets the sizes of the object
	 *
	 * @param sizes
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setSizes(@Nullable Map<LayoutResponsiveSize, Integer> sizes)
	{
		this.sizes = sizes;
		return (J) this;
	}
}
