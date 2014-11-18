/*
 * Copyright 2014 the original author or authors.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package de.schildbach.wallet.util;

import java.lang.reflect.Method;

/**
 * @author Andreas Schildbach
 */
public final class Trace
{
	public static void beginSection(final String sectionName)
	{
		try
		{
			Method beginSection = Class.forName("android.os.Trace").getMethod("beginSection", String.class);
			beginSection.invoke(null, sectionName);
		}
		catch (final Exception x)
		{
			throw new RuntimeException(x);
		}
	}

	public static void endSection()
	{
		try
		{
			Method beginSection = Class.forName("android.os.Trace").getMethod("endSection");
			beginSection.invoke(null);
		}
		catch (final Exception x)
		{
			throw new RuntimeException(x);
		}
	}
}
